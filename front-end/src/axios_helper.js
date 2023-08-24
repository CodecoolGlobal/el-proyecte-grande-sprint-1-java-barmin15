import axios from "axios";

axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.headers.post["Content-Type"] = "application/json";

export const getAuthToken = () => {
  return window.sessionStorage.getItem("auth_token");
};


export const setAuthToken = (token) => {
  window.sessionStorage.setItem("auth_token", token);
};

export const request = (method, url, data) => {
  let headers = {};

  if (getAuthToken() !== null && getAuthToken() !== "null") {
    headers = { Authorization: `Bearer ${getAuthToken()}` };
  }

  return axios({
    method: method,
    headers: headers,
    url: url,
    data: data,
  });
};

export const getRequest = (url) => {
  let headers = {};

  if (getAuthToken() !== null && getAuthToken() !== "null") {
    headers = { Authorization: `Bearer ${getAuthToken()}` };
  }

  return axios({
    method: "GET",
    headers: headers,
    url: url
  });
}
