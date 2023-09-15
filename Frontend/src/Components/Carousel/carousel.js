import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import './carousel.css'
const carousel = () => {
  return (
    <>
      <div
        id="carouselExampleRide"
        className="carousel slide carousel-css "
        data-bs-ride="true"
      >
        <div className="carousel-inner">
          <div className="carousel-item active">
            <img
              src="https://www.thomascook.in/images/home-page-banners/2023/aug/Costa-Cruise-Wb-banner-1920-545-1.jpg"
              className="d-block w-100 carousel-img"
              alt="Loading Error !"
            />
          </div>
          <div className="carousel-item">
            <img
              src="https://www.thomascook.in/images/home-page-banners/2023/mar/club-vistara-1920x545-1.jpg"
              className="d-block w-100"
              alt="Loading Error !"
            />
          </div>
          <div className="carousel-item">
            <img
              src="https://www.thomascook.in/images/home-page-banners/2023/aug/northern-lights-1920x545.jpg"
              className="d-block w-100"
              alt="Loading Error !"
            />
          </div>
          <div className="carousel-item">
            <img
              src="https://www.thomascook.in/images/home-page-banners/2023/july/study-buddy-1920-545-home.jpg"
              className="d-block w-100"
              alt="Loading Error !"
            />
          </div>
          <div className="carousel-item">
            <img
              src="https://www.thomascook.in/images/home-page-banners/2023/mar/Vietnam-Banner-1920x545.jpg"
              className="d-block w-100"
              alt="Loading Error !"
            />
          </div>
       
        </div>
        <button
          className="carousel-control-prev"
          type="button"
          data-bs-target="#carouselExampleRide"
          data-bs-slide="prev"
        >
          <span className="carousel-control-prev-icon" aria-hidden="true" />
          <span className="visually-hidden">Previous</span>
        </button>
        <button
          className="carousel-control-next"
          type="button"
          data-bs-target="#carouselExampleRide"
          data-bs-slide="next"
        >
          <span className="carousel-control-next-icon" aria-hidden="true" />
          <span className="visually-hidden">Next</span>
        </button>
      </div>
    </>
  );
};

export default carousel;
