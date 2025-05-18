import CustHomeNv from "./../../components/CustHomeNv";
import axios from "axios";
import { useState, useEffect } from "react";
import config from "../../config";
import { toast } from "react-toastify";
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import ToggleButton from 'react-bootstrap/ToggleButton';

import ToggleButtonGroup from 'react-bootstrap/ToggleButtonGroup';

const CustomerHome = () => {
  const [category, setCategory] = useState([]);
  const [type, setType] = useState([]);
  const [menu, setMenu] = useState([]);
  const [quantity, setQuantity] = useState(0);

  const [radioValue, setRadioValue] = useState('0');
  const [selectedCategory, setSelectedCategory] = useState(null);

  const radios = [
    { name: 'ALL', value: '0' },
    { name: 'VEG', value: '1' },
    { name: 'NON VEG', value: '2' },
  ];

  useEffect(() => {
    allCategories();
    allMenus();
    allTypes();
  }, []);

  useEffect(() => {
    menuByType(radioValue);
  }, [radioValue])

  const handleCategorySelect = (cat) => {
    if (selectedCategory === cat) {
      // If the same category is clicked again, unselect it
      setSelectedCategory(null);
    } else {
      // Otherwise, select the clicked category
      setSelectedCategory(cat);
    }
  };

  const allCategories = () => {
    axios.get(`${config.serverURL}/category/all`).then((Response) => {
      const result = Response.data;

      if (result["status"] === "success") {

        setCategory(result["data"]);
      } else {
        toast.error("ERROR OCCURED...");
      }
    });
  };

  const allTypes = () => {
    axios.get(`${config.serverURL}/category/allTypes`).then((Response) => {
      const result = Response.data;

      if (result["status"] === "success") {
        console.log(result);
        setType(result["data"]);
      } else {
        toast.error("ERROR OCCURED...");
      }
    });
  };

  const allMenus = () => {

    axios.get(`${config.serverURL}/menu/allMenus`).then((Response) => {
      const result = Response.data;

      if (result["status"] === "success") {
        console.log(result);
        setMenu(result["data"]);
      } else {
        toast.error("ERROR OCCURED...");
      }
    });
  };

  const addToCart = (id) => {
    const userId = sessionStorage.getItem("customerId");
    if (quantity === 0) {
      toast.warning("Enter Quantity to add into cart");
    } else {
      axios
        .post(
          `${config.serverURL}/cart/add`,
          { menuId: id, userId: userId, quantity: quantity },
          { "Content-Type": "application/json" }
        )
        .then((Response) => {
          const result = Response.data;

          if (result["status"] === "success") {
            console.log(result);
            toast.success("menu added to cart");
            setQuantity(0);
          } else {
            toast.error("ERROR OCCURED...");
          }
        });
    }
  };

  // const addToCart = (id, quantity) => {
  //   // Assuming userId is retrieved from somewhere in your code, like session storage
  //   const userId = sessionStorage.getItem("customerId");
  
  //   // Fetch the user's cart items
  //   axios.get(`${config.serverURL}/cart/all/${userId}`)
  //     .then((response) => {
  //       const cartItems = response.data;
  //       // Check if the cart already contains the menu item
  //       const existingItem = cartItems.find(item => item.selectedMenu.id === id);
  
  //       if (existingItem) {
  //         // If it does, update the quantity
  //         const updatedQuantity = existingItem.quantity + quantity;
  //         axios.put(`${config.serverURL}/cart/update`, { cartId: existingItem.id, quantity: updatedQuantity })
  //           .then((updateResponse) => {
  //             // Handle response for updating cart item quantity
  //             console.log(updateResponse.data);
  //             toast.success("Quantity updated");
  //           })
  //           .catch(error => {
  //             // Handle error in updating cart item quantity
  //             console.error("Error updating cart quantity:", error);
  //             toast.error("Could not update quantity");
  //           });
  //       } else {
  //         // If it does not, add a new item to the cart
  //         axios.post(`${config.serverURL}/cart/add`, { menuId: id, userId: userId, quantity: quantity })
  //           .then((addResponse) => {
  //             // Handle response for adding new cart item
  //             console.log(addResponse.data);
  //             toast.success("Item added to cart");
  //           })
  //           .catch(error => {
  //             // Handle error in adding new cart item
  //             console.error("Error adding item to cart:", error);
  //             toast.error("Could not add item to cart");
  //           });
  //       }
  //     })
  //     .catch(error => {
  //       // Handle error in fetching cart items
  //       console.error("Error fetching cart items:", error);
  //       toast.error("Could not fetch cart items");
  //     });
  // };
  


  const menuByCategory = (catId) => {
    setRadioValue('0');
    axios
      .get(`${config.serverURL}/menu/allMenuByType/${catId}`)
      .then((Response) => {
        const result = Response.data;

        if (result["status"] === "success") {

          console.log(result);
          setMenu(result["data"]);
        } else {
          toast.error("ERROR OCCURED...");
        }
      });
  };

  const menuByType = (id) => {

    if (id === '0') {
      allMenus();
    }
    else {
      setSelectedCategory(null);
      console.log(id);
      axios
        .get(`${config.serverURL}/menu/allMenuByTypeVnV/${id}`)
        .then((Response) => {
          const result = Response.data;

          if (result["status"] === "success") {
            setMenu(result["data"]);
          } else {
            toast.error("ERROR OCCURED...");
          }
        });
    }
  };

  return (
    <div className="container-fluid" >
      <CustHomeNv />
      <div style={{ textAlign: "right" }}>
        <i>Free Delivery on orders above 499</i>
      </div>
      <br></br>

      <ButtonGroup>
        {radios.map((radio, idx) => (
          <ToggleButton
            key={idx}
            id={`radio-${idx}`}
            type="radio"
            variant={idx % 2 ? 'outline-success' : idx === 0 ? 'outline-secondary' : 'outline-danger'}
            name="radio"
            value={radio.value}
            checked={radioValue === radio.value}
            onChange={(e) => setRadioValue(e.currentTarget.value)}
          >
            {radio.name}
          </ToggleButton>
        ))}
      </ButtonGroup>
      <br></br>
      <div className="mt-3">
        <ToggleButtonGroup value={selectedCategory} type="radio" name="options" defaultValue={1} onChange={handleCategorySelect}>

          {category.map((cat) => (
            <ToggleButton variant={selectedCategory === cat ? "secondary" : "outline-secondary"} key={cat.id} id={`tbg-radio-${cat.id}`} value={cat} onClick={() => menuByCategory(cat.id)}>
              {cat.name}
            </ToggleButton>
          ))}
        </ToggleButtonGroup>
      </div>

      <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
        {menu.map((m) => {
          return (
            <div
              key={m.id}
              className="col"
              style={{
                position: "relative",
                padding: 20,
                display: "inline-block",
                cursor: "pointer",
              }}
            >
              <img
                alt="menu"
                style={{
                  height: 200,
                  width: "100%",
                  display: "block",

                  borderRadius: 10,
                }}
                src={config.serverURL + "/" + m.image}
              />
              <div style={{ marginTop: 20 }}>
                <h5 className="card-title">{m.productName} <span><h6>[{m.restaurant.name}]</h6></span></h5>

                <p>
                  {m.description} <br />
                  Rs. {m.price}
                </p>
              </div>

              <div className="row">
                <div className="col">
                  <input
                    type="number"
                    id="form3Example97"
                    className="form-control form-control-sm"
                    placeholder="Enter Qty"
                    onChange={(e) => {
                      setQuantity(e.target.value);
                    }}
                  />
                </div>
                <div className="col">
                  <button
                    onClick={() => addToCart(m.id)}
                    type="button"
                    className="btn btn-success btn-sm"
                    style={{ marginTop: 5 }}
                  >
                    Add To Cart
                  </button>
                </div>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default CustomerHome;