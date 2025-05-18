import RIYAJ from "../../images/RIYAJ.jpg";
import ROHAN from "../../images/ROHAN.jpg";
import YASHASHRI from "../../images/YASHASHRI.jpg";
import CustHomeNv from "../../components/CustHomeNv";
import RestoNav from "../../components/RestoNav";
import NavbarDeliveryBoy from "../../components/navbarDeliveryBoy";

const ContactUs = () => {
  return (
    <div className="container-fluid" >
     {sessionStorage.getItem("role") === "CUSTOMER" && <CustHomeNv />}
     {sessionStorage.getItem("role") === "RESTAURANT" && <RestoNav/>}
     {sessionStorage.getItem("role") === "DELIVERYBOY" && <NavbarDeliveryBoy/>}
      <div style={{ textAlign: "center", marginTop: 40 }}>
        <h5>
          <b style={{ fontSize: 80, color: "#5C41A8" }}>CloudCuisine</b>
        </h5>
        <div
          className="container"
          style={{
            textAlign: "justify",
            fontFamily: "sans-serif",
            textIndent: 30,
            fontStyle: "italic",
          }}
        >
          <p>
            This website can primarily be used for ordering food items from the kitchens at nearby location .
            This is achieved through an easy to use graphical interface menu options.
            It is managed by the admin. Restaurants can list their available food menus. Users can add number of items to the cart.
            Different payment options are available to continue the order.Deliveryboy can view the order assigned and its corresponding address of delivery.
          </p>
        </div>
        <hr />
        <div className="container" style={{ margin: 30, marginLeft: 140 }}>
          <h4 style={{ marginLeft: -140 }}>Contact Us</h4>
          <div
            className="row"
            style={{ height: 50, marginTop: 30, marginRight: 100 }}
          >
            <div className="col">
              <img
                src={RIYAJ}
                className="card-img-top"
                style={{
                  height: 250,
                  width: 200,
                  boxShadow: "0px 4px 18px 3px rgba(0,0,0,0.38)",
                  display: "block",
                  borderRadius: 5,
                }}
                alt="..."
              />
              <div style={{ marginLeft: -100, marginTop: 10 }}>
                {" "}
                <h5 style={{ textAlign: "center" }}>RIYAJ BAGWAN</h5>
              </div>
              <div
                style={{
                  marginLeft: -60,
                  marginTop: 10,
                  marginBottom: 20,
                  color: "blue",
                }}
              >
                {" "}
                <h7 style={{ textAlign: "center" }}>rbagwan88@gmail.com</h7>
              </div>
              <div
                style={{
                  marginLeft: -40,
                  marginTop: 10,
                  marginBottom: 20,
                  color: "blue",
                }}
              >
                {" "}
                <h7 style={{ textAlign: "center" }}> +919988899988</h7>
              </div>
            </div>
            <div className="col">
              <img
                src={ROHAN}
                className="card-img-top"
                style={{
                  height: 250,
                  width: 200,
                  boxShadow: "0px 4px 18px 3px rgba(0,0,0,0.38)",
                  display: "block",
                  borderRadius: 5,
                }}
                alt="..."
              />
              <div style={{ marginLeft: -110, marginTop: 10 }}>
                {" "}
                <h5 style={{ textAlign: "center" }}>ROHAN RAIKWAR</h5>
              </div>
              <div
                style={{
                  marginLeft: -60,
                  marginTop: 10,
                  marginBottom: 20,
                  color: "blue",
                }}
              >
                {" "}
                <h7 style={{ textAlign: "center" }}>rohan@gmail.com</h7>
              </div>
              <div
                style={{
                  marginLeft: -40,
                  marginTop: 10,
                  marginBottom: 20,
                  color: "blue",
                }}
              >
                {" "}
                <h7 style={{ textAlign: "center" }}> +919889988899</h7>
              </div>
            </div>
            <div className="col">
              <img
                src={YASHASHRI}
                className="card-img-top"
                style={{
                  height: 250,
                  width: 200,
                  boxShadow: "0px 4px 18px 3px rgba(0,0,0,0.38)",
                  display: "block",
                  borderRadius: 5,
                }}
                alt="..."
              />
              <div style={{ marginLeft: -110, marginTop: 10 }}>
                {" "}
                <h5 style={{ textAlign: "center" }}>YASHASHRI</h5>
              </div>
              <div
                style={{
                  marginLeft: -60,
                  marginTop: 10,
                  marginBottom: 20,
                  color: "blue",
                }}
              >
                {" "}
                <h7 style={{ textAlign: "center" }}>YASHASHRI@gmail.com</h7>
              </div>
              <div
                style={{
                  marginLeft: -40,
                  marginTop: 10,
                  marginBottom: 20,
                  color: "blue",
                }}
              >
                {" "}
                <h7 style={{ textAlign: "center" }}> +919404027890</h7>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ContactUs;