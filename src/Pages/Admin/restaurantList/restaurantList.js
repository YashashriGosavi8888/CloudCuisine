import axios from "axios";
import { useState, useEffect } from "react";
import config from "../../../config";
import NavbarAdmin from "../../../components/navbarAdmin";
import { useNavigate } from "react-router-dom";

const RestaurantList = () => {
  const navigate = useNavigate();
  const [restaurantList, setRestaurantList] = useState([]);
  const [ISActive, setisActive] = useState("");

  useEffect(() => {
    console.log(`list is loaded`);
    getRestaurantList();
  }, []);

  // const getRestaurantList = () => {
  //   axios.get(config.serverURL + "/admin/getAllRestaurant").then((response) => {
  //     const result = response.data;
  //     console.log(result);
  //     if (result.status === "Success") {
  //       setRestaurantList(result.data);
  //       setisActive(result.isActive);
  //     } else {
  //       alert("error while loading list of Restaurant List");
  //     }
  //   });
  // };

  const getRestaurantList = () => {
    axios
      .get(config.serverURL + "/admin/getAllRestaurant")
      .then((response) => {
        const result = response.data;
        if (result.status === "Success") {
          setRestaurantList(
            result.data.map((restaurant) => ({
              ...restaurant,
              // Adjust based on the actual data type of `isActive`
              isChecked: restaurant.isActive === "1", // If `isActive` is a string
              // isChecked: restaurant.isActive === 1, // If `isActive` is a number
            }))
          );
        } else {
          alert("Error while loading list of Restaurant List");
        }
      })
      .catch((error) => {
        console.error("Error fetching restaurant list:", error);
        alert("An error occurred while loading the restaurant list");
      });
  };
  
  const ChangeStatus = (restaurantId, isActive) => {
    axios
      .put(`${config.serverURL}/admin/getAllActiveRestaurants`, {
        id: restaurantId,
        isActive: isActive,
      })
      .then((response) => {
        const result = response.data;
        console.log(result);
        if (result.status === "Success") {
          console.log("Status status updated successfully");
        } else {
          alert("Error while updating status");
        }
      })
      .catch((error) => {
        console.error("Error in ActiveDeactive:", error.message);
        alert("An error occurred while updating customer status");
      });
  };

  const GetDetails = (id, name) => {
    navigate("/getRestaurantDetails", {
      state: { restaurentId: id, restaurantName: name },
    });
  };

  const GetMenu = (id) => {
    navigate("/getRestaurantMenu", { state: { restaurentId: id } });
  };

  return (
    <div className="container-fluid">
      <NavbarAdmin />
      <div className="container">
        <header style={{ textAlign: "center", fontSize: 30 }}>
          <b>Restaurants List</b>
        </header>
        <table
          className="table table-responsive table-striped table-hover table-bordered"
          style={{ marginTop: 60 }}
        >
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">name</th>
              <th scope="col">Email</th>
              <th scope="col">contact</th>
              <th scope="col">Reviews</th>
              <th scope="col">Restaurant Menu</th>
              <th scope="col">Status</th>
            </tr>
          </thead>
          <tbody>
            {restaurantList.map((user) => {
              return (
                <tr>
                  <td scope="col">{user.id}</td>
                  <td scope="col">{user.name}</td>
                  <td scope="col">{user.email}</td>
                  <td scope="col">{user.contact}</td>
                  <td>
                    <button
                      onClick={() => GetDetails(user.id, user.name)}
                      className="btn"
                      style={{ backgroundColor: "#5C41A8", color: "white" }}
                    >
                      Reviews
                    </button>
                  </td>
                  <td>
                    <button
                      onClick={() => GetMenu(user.id)}
                      className="btn"
                      style={{ backgroundColor: "#5C41A8", color: "white" }}
                    >
                      Menu
                    </button>
                  </td>

                  <td>
                    {/* <input
                      type="checkbox"
                      id={`check-${user.id}`}
                      checked={user.isActive}
                      onClick={() => ActiveDeactive(user.id)}
                      readOnly // Add readOnly to suppress the console warning about controlled components
                    ></input> */}

                    <div className="form-outline mb-4">
                      {/* <input
                        type="checkbox"
                        id="form3Example97"
                        defaultValue={user.isActive}
                        onChange={(e) => {
                          setisActive(e.target.value);
                         
                        }}
                        onClick={() => ChangeStatus(user.id)}
                      /> */}

                      <input
                        type="checkbox"
                        id="form3Example97"
                        checked={user.isActive} // Assuming `user` is the state for the current user, and it has an `isChecked` property.
                        onChange={(e) => {
                          setisActive(e.target.checked); // Use `checked` for boolean value
                          ChangeStatus(user.id, e.target.checked); // Pass the new status directly
                        }}
                      />
                    </div>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default RestaurantList;
