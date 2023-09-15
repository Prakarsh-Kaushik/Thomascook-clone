import React from 'react'
import {Card, CardBody} from "reactstrap";


import "./TourCard.css";
const TourCard = ({tour}) => {
   const{id,city ,price ,imageLink} = tour;
  return (
    <>
    <section>
    <div className='tour__card'>
        <Card>
            <div className='tour__img'>
                <img src={imageLink}/>
            </div>
        </Card>
        <CardBody>
            <div className='card__top d-flex align-items-center justify-content-between'>
                <span className='tour__location d-flex align-items-center gap-1'>
                    {city}
                </span>
                <div className='card__bottom '>
                <h5>{price}</h5>
            </div>
            
            </div>
            
        </CardBody>
    </div>
    </section>
    </>
  )
}

export default TourCard;