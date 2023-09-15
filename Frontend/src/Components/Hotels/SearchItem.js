import "./searchItem.css";
import { privateAxios } from "../../services/helper";
import { useEffect, useState } from "react";
import { id } from "date-fns/locale";
import { useNavigate } from "react-router-dom";
const SearchItem = (props) => {
const item=props.hotelData

    const navigate = useNavigate();
    const handleSubmit =(hotelId)=>{
      navigate("/hotels/list/hotelPages",{ state: { hotelId}})
      }
            
           
       
  return (
    <>
 
    <div className="searchItem">
     <img
        src="https://cf.bstatic.com/xdata/images/hotel/square600/261707778.webp?k=fa6b6128468ec15e81f7d076b6f2473fa3a80c255582f155cae35f9edbffdd78&o=&s=1"
        alt=""
        className="siImg"
      />
     
      <div className="siDesc">
        <h1 className="siTitle">{item.name}</h1>
        <span className="siDistance"><b>{item.description}</b></span>
        <span className="siTaxiOp">Free airport taxi</span>
        <span className="siSubtitle">
      ROOMS:  {item.totalRoom}
        </span>
        <span className="siFeatures">
          Entire studio • 1 bathroom • 21m² 1 full bed
        </span>
        <span className="siCancelOp">Free cancellation </span>
        <span className="siCancelOpSubtitle">
          You can cancel later, so lock in this great price today!
        </span>
      </div>
      <div className="siDetails">
        <div className="siRating">
          <span>{item.street}</span>
          <button>{item.pincode}</button>
        </div>
        <div className="siDetailTexts">
          <span className="siPrice">Rs.{item.pricePerDay}</span>
          <span className="siTaxOp">Includes taxes and fees</span>
         
          <button className="siCheckButton" onClick={()=>handleSubmit(item.id)} >See availability</button>
          
        </div>
      </div>
    </div>
    
    </>
  );
};

export default SearchItem;