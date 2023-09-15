import React from 'react'
import TourCard from '../Card/TourCard';
import HoneymoonTourData from "../../assets/data/HoneymoonTourData"
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import {Col} from 'reactstrap'

const HoneymoonFeaturedTours = () => {
  return (
    <>
   {HoneymoonTourData?.map(tour => (
    <Col lg="3" className='mb-4' key={tour.id}>
        <TourCard tour={tour}/>
    
    </Col>
   ))}
  
  </>
  )
  
}

export default HoneymoonFeaturedTours