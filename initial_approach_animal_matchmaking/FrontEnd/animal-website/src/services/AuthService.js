import axios from "axios";

const url = "http://localhost:3000/api/";
export default {
  loginAdder(credentials) {
    return axios
        .post(url + "adder/get/", credentials)
        .then((response) => response.data);
  },
  loginAdopter(credentials) {
    return axios
        .post(url + "adopter/get/", credentials)
        .then((response) => response.data);
  },
  signUpAdder(credentials) {
    return axios
        .post(url + "adder/add/", credentials)
        .then((response) => response.data);
  },
  signUpAdopter(credentials) {
    return axios
        .post(url + "adopter/add/", credentials)
        .then((response) => response.data);
  },
};
