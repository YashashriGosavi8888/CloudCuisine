import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./Address.css";
import config from "../../config";
import { toast } from "react-toastify";
import CustHomeNv from "./../../components/CustHomeNv";

const SelectAddress = () => {
  const [address, setAddress] = useState([]);
  const userid = sessionStorage.getItem("customerId");
  let navigate = useNavigate();
  var result;
  useEffect(() => {
    getAllAddress();
    console.log(`address is loaded`);
  }, []);

  const getAllAddress = () => {
    axios.get(`${config.serverURL}/address/show/${userid}`).then((response) => {
      result = response.data;
      if (result.status === "Success") {
        setAddress(result.data);
        console.log(result.data);
        console.log(address);
      } else {
        toast.error("error while loading list of cart");
      }
    });
  };
  const nextPage = () => {
    var form = document.getElementById("FORM");
    const formData = new FormData(form);
    const addId = formData.get("radio");

    if (addId.length == 0) {
      toast.warning("please select address");
    } else {
      navigate("/Payment", { state: { addressId: addId } });
    }
  };
  const goToPage = () => {
    navigate("/AddAddress");
  };

  return (
    <div className="container-fluid">
      <CustHomeNv />
      <div class="myStyle">
        <form id="FORM">
          <h4 style={{ marginLeft: 240, marginTop: 20 }}>Address</h4>
          {address.map((add) => {
            return (
              <div
                class="form-check"
                style={{ marginLeft: 150, marginTop: 20 }}
              >
                <input
                  class="form-check-input"
                  type="radio"
                  name="radio"
                  id="flexRadioDefault1"
                  value={add.id}
                />
                <label class="form-check-label" for="flexRadioDefault1">
                  <div class="my_text">
                    <div>
                      {" "}
                      {add.line1}, {add.line2},
                    </div>
                    <div>
                      {add.city}, {add.state}, pin: {add.pincode}
                    </div>
                    <div> Mob:{add.contactNo}</div>
                  </div>
                </label>
              </div>
            );
          })}

          <button
            onClick={nextPage}
            className="btn btn-success "
            style={{ marginLeft: 240, marginTop: 50 }}
          >
            proceed
          </button>
          <button
            onClick={goToPage}
            className="btn btn-dark "
            style={{ marginLeft: 225, marginTop: 20 }}
          >
            Add address
          </button>
        </form>
      </div>
    </div>
  );
};

export default SelectAddress;