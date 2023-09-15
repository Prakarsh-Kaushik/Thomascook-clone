import React from 'react'
import TourCard from '../Card/TourCard';
import tourdata from "../../assets/data/tours"
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import {Col} from 'reactstrap'
const featuredTourList = () => {
  return (
  <>
   {tourdata?.map(tour => (
    <Col lg="3" className='mb-4' key={tour.id}>
        <TourCard tour={tour}/>
    
    </Col>
   ))}
  
  </>
  )
}

export default featuredTourList;