import NavbarAdmin from "../../../components/navbarAdmin";
import config from "../../../config";
import axios from "axios";
import { useState, useEffect } from "react";
const CustomerList = () => {
  const [customerList, setCustomerList] = useState([]);
  
  useEffect(() => {
    console.log(` is loaded`);
    getCustomerList();
  }, []);

  const getCustomerList = () => {
    axios.get(config.serverURL + "/admin/getAllCustomer").then((response) => {

      const result = response.data;

      if (result.status === "Success") {
        setCustomerList(result.data);
      } else {
        alert("error while loading list of DeliveryBoyList");
      }
    });
  };
  return (
    <div className="container-fluid">
      <NavbarAdmin />
      <div className="container">
        <header style={{ textAlign: "center", fontSize: 30 }}>
          <b>Customer List</b>
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
              <th scope="col">Status</th>

            </tr>
          </thead>
          <tbody>
            {customerList.map((user) => {
              return (
                <tr>
                  <td scope="col">{user.id}</td>
                  <td scope="col">{user.name}</td>
                  <td scope="col">***********</td>
                  <td scope="col">***********</td>
                  <td scope="col">{user.status}</td>

                </tr>
              );
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default CustomerList;
