import React from 'react'
import TourCard from '../Card/TourCard';
import IndianTourData from "../../assets/data/IndianTourData"
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import {Col} from 'reactstrap'

const IndiaFeaturedTours = () => {
    return (
        <>
         {IndianTourData?.map(tour => (
          <Col lg="3" className='mb-4' key={tour.id}>
              <TourCard tour={tour}/>
          
          </Col>
         ))}
        
        </>
        )
}

export default IndiaFeaturedTours