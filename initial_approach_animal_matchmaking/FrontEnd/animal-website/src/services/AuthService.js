import axios from "axios";

const url = "placeholder/api";
export default {
  loginAdder(credentials) {
    return axios
        .post(url + "adder/get/", credentials, {
            headers: {"content-type": "application/json"},
        })
        .then((response) => response.data);
  },
  loginAdopter(credentials) {
      return axios
          .post(url + "adopter/get/", credentials, {
              headers: {"content-type": "application/json"},
          })
          .then((response) => response.data);
  },
  signUpAdder(credentials) {
      return axios
          .post(url + "adder/add/", credentials, {
              headers: {"content-type": "application/json"},
          })
          .then((response) => response.data);
  },
  signUpAdopter(credentials) {
      return axios
          .post(url + "adopter/add/", credentials, {
              headers: {"content-type": "application/json"},
          })
          .then((response) => response.data);
  },
};
