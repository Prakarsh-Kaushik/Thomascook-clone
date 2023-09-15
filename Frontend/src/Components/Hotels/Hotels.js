import React ,{useEffect, useState}from 'react'
import "./Hotels.css"
import { DateRange } from 'react-date-range'
import 'react-date-range/dist/styles.css'; // main style file
import 'react-date-range/dist/theme/default.css'; // theme css file
import { format } from 'date-fns';
import { useNavigate } from "react-router-dom";
import { privateAxios } from '../../services/helper';
const Hotels = () => {
  const [destination, setDestination] = useState("");
  const [openDate, setOpenDate] = useState(false);
  const [openOptions, setOpenOptions] = useState(false);
  const [id, setId] = useState();
  const [options, setOptions] = useState({
    adult: 1,
    children: 0,
    room: 1,
  });
  const [date, setDate] = useState([
    {
      startDate: new Date(),
      endDate: new Date(),
      key: "selection",
    },
  ]);


 
  const handleOption = (name, operation) => {
    setOptions((prev) => {
      return {
        ...prev,
        [name]: operation === "i" ? options[name] + 1 : options[name] - 1,
      };
    });
  };
  const navigate = useNavigate();
  const handleSearch = () => {
    navigate("/hotels/list", { state: { destination, date, options } });
  };

  return (
<>
<div>
<img src="https://www.thomascook.in/images/hotel/slider/banner-img-desktop.webp" alt="hotel-image" className='hotelImg'/>
</div>

<div className='headerSearch'>
  <div className='headerSearchItem'>
    <input type="text" placeholder='Where are you going?' className='headerSearchInput' onChange={(e) => setDestination(e.target.value)}/>


  </div>
  <div className='headerSearchItem'>
    <span  onClick={() => setOpenDate(!openDate)}
    className='headerSearchText'>{`${format(date[0].startDate, "MM/dd/yyyy")} to ${format(
                  date[0].endDate,
                  "MM/dd/yyyy"
                )}`}</span>
   {openDate && (
                  <DateRange
                    editableDateInputs={true}
                    onChange={(item) => setDate([item.selection])}
                    moveRangeOnFirstSelection={false}
                    ranges={date}
                    className="date"
                    minDate={new Date()}
                  />
                )}

  </div>
  <div className='headerSearchItem'>
   <span onClick={()=>setOpenOptions(!openOptions)}  className='headerSearchText'>{`${options.adult} adult · ${options.children} children · ${options.room} room`}</span>
 {openOptions &&  <div className='options'>
    <div className='optionItem'>
      <span className='optionText'>Adult</span>
      <div className='optionCounter'>
      <button 
       disabled={options.adult<=1}
       className='optionCounterButton'  onClick={() => handleOption("adult", "d")}>-</button>
      <span className='optionCounterNumber'>{options.adult}</span>
      <button 
      
      className='optionCounterButton'  onClick={() => handleOption("adult", "i")}>+</button>
    </div>
    </div>
    <div className='optionItem'>
      <span className='optionText'>Children</span>
      <div className='optionCounter'>
      <button 
       disabled={options.children<=0}
      className='optionCounterButton'  onClick={() => handleOption("children", "d")}>-</button>
      <span className='optionCounterNumber'>{options.children}</span>
      <button className='optionCounterButton' onClick={() => handleOption("children", "i")}>+</button>
    </div>
    </div>
    <div className='optionItem'>
      <span className='optionText'>Room</span>
      <div className='optionCounter'>
      <button 
       disabled={options.room<=1}
      className='optionCounterButton' onClick={() => handleOption("room", "d")}>-</button>
      <span className='optionCounterNumber'>{options.room}</span>
      <button className='optionCounterButton' onClick={() => handleOption("room", "i")}>+</button>
    </div>
    </div>

   </div>
    
   }
  </div>
  <div className='headerSearchItem'>
  <button className='headerBtn' onClick={handleSearch} >Search</button>

  </div>
</div>



{" "}







<div >
  <br/>
  <br/>
      <h2 class="main-head">Online Hotel Bookings made simpler than ever with Thomas Cook</h2>
      <p className='content'>
    Thomas Cook offers hotel bookings across the world at economical prices; whether you are traveling within India or abroad and are looking for hotels, then we’ve got you covered. Hotels form an important part of every travel and if this element goes wrong, your vacation is sure to go for a toss! Therefore, when you book hotels online, you need to make sure it’s the one that you want! From budget hotels, cheap hotels, to 5-star hotels and luxury suites, we have a wide range for every location.
    </p>
    <p className='content'>
    You can now make hotel bookings on the go. To book hotels online, all you have to do is simply log on to the Thomas Cook website, enter the required details, and we will show you the best matches. Using our filter option, you can make the search more efficient and pick the hotel that best fits your requirement. Our secure payment gateway ensures a secure money transaction.

    </p>
    </div>

</>
  )
}

export default Hotels