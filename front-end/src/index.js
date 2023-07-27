import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import reportWebVitals from "./Vitals/reportWebVitals";


import Layout from "./Layout/layout";
import AllEvent from "./App/Pages/AllEvent";
import EventForm from "./App/Pages/EventForm";
import Register from "./App/Pages/RegisterPage";
import LogIn from "./App/Pages/LogInPage";

const Router = createBrowserRouter([
  {
    path: "/",
    element: <Register />
  },
  {
    path: "/login",
    element: <LogIn />
  },
  {
    path: "/event",
    element: <Layout />,
    children: [
      {
        path: "/event/all",
        element: <AllEvent />,
      }, {
        path: "/event/create",
        element: <EventForm />,
      },
    ],
  }
]);


const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={Router} />
  </React.StrictMode>
);

reportWebVitals();
