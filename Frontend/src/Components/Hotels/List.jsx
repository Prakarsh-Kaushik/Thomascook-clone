import { useState,useEffect } from "react";
import { useLocation } from "react-router-dom";
import { format } from "date-fns";
import React from 'react'
import { DateRange } from "react-date-range";
import SearchItem from "./SearchItem";
import { privateAxios } from '../../services/helper';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./list.css";
const List = () => {
    const location = useLocation();

    const [destination, setDestination] = useState(location.state.destination);
    const [date, setDate] = useState(location.state.date);
    const [openDate, setOpenDate] = useState(false);
    const [options, setOptions] = useState(location.state.options);
    const [id, setId] = useState();
    const [hotelData,setHotelData] = useState();
    const fetchHotel =async()=>{
      const response = await privateAxios.get("http://localhost:8080/api/location/fetch")
      const result = await response.data.locations;
      const mani= result.filter((user)=>{
        const nani= user.city.includes(destination)
        return nani;
      }) 
      setId(mani[0].id)
        }
      const fetchHotelByLocation = async()=>{
          const response2 =   await privateAxios.get(`http://localhost:8080/api/hotel/location?locationId=${id}`)
           
            const result2= await response2.data.hotels;
       
            setHotelData(result2);
            


            }
            useEffect(()=>{
              fetchHotel();
          
          
                },[])
                

             
const onSearch = ()=>{
  fetchHotelByLocation().then(()=>
  toast.success(`Hotel Fetched Successfully`, {
    position: "top-right",
    autoClose: 3000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
    draggable: true,
    progress: undefined,
    theme: "dark",
  })

  )

}


  return (
  <>
      <div>
   
      <div className="listContainer">
        <div className="listWrapper">
          <div className="listSearch">
            <h1 className="lsTitle">Search</h1>
            <div className="lsItem">
              <label>Destination</label>
              <input placeholder={destination} type="text" />
            </div>
            <div className="lsItem">
              <label>Check-in Date</label>
              <span onClick={() => setOpenDate(!openDate)}>{`${format(
                date[0].startDate,
                "MM/dd/yyyy"
              )} to ${format(date[0].endDate, "MM/dd/yyyy")}`}</span>
              {openDate && (
                <DateRange
                  onChange={(item) => setDate([item.selection])}
                  minDate={new Date()}
                  ranges={date}
                />
              )}
             
            </div>
            <div className="lsItem">
              <label>Options</label>
              <div className="lsOptions">
                <div className="lsOptionItem">
                  <span className="lsOptionText">
                    Min price <small>per night</small>
                  </span>
                  <input type="number" className="lsOptionInput" />
                </div>
                <div className="lsOptionItem">
                  <span className="lsOptionText">
                    Max price <small>per night</small>
                  </span>
                  <input type="number" className="lsOptionInput" />
                </div>
                <div className="lsOptionItem">
                  <span className="lsOptionText">Adult</span>
                  <input
                    type="number"
                    min={1}
                    className="lsOptionInput"
                    placeholder={options.adult}
                  />
                </div>
                <div className="lsOptionItem">
                  <span className="lsOptionText">Children</span>
                  <input
                    type="number"
                    min={0}
                    className="lsOptionInput"
                    placeholder={options.children}
                  />
                </div>
                <div className="lsOptionItem">
                  <span className="lsOptionText">Room</span>
                  <input
                    type="number"
                    min={1}
                    className="lsOptionInput"
                    placeholder={options.room}
                  />
                </div>
              </div>
            </div>
            <button onClick={onSearch}>Search</button>
          </div>
          <div className="listResult">
          
{hotelData &&
hotelData.map(item=>(
<SearchItem hotelData={item} key={item.id} />
))

}
            
           
          </div>
        </div>
      </div>
    </div>
    <ToastContainer/>
    
  
  </>
  )
}

export default List