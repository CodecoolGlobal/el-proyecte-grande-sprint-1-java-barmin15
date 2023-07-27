import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import reportWebVitals from "./Vitals/reportWebVitals";


import Layout from "./Layout/layout";
import AllEvent from "./App/Pages/AllEvent";
import EventForm from "./App/Pages/EventForm";
import UserProfile from "./App/Pages/UserProfile";

const Router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/events",
        element: <AllEvent />,
      },{
        path: "/create",
        element: <EventForm />,
      },{
        path: "/ownprofile",
        element: <UserProfile />,
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
