import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import reportWebVitals from "./Vitals/reportWebVitals";


import Layout from "./Layout/layout";
import EventForm from "./components/EventForm";
import AllEvent from "./components/AllEvent.js";

const Router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <AllEvent />,
      },{
        path: "/create",
        element: <EventForm />,
      },
      
    ],
  },
]);


const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={Router} />
  </React.StrictMode>
);

reportWebVitals();
