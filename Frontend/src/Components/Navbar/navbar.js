import React from 'react'
import "./navbar.css";
import logo from "../../assets/logo.jpg"
import {GiHamburgerMenu} from "react-icons/gi";
import { Link,NavLink } from 'react-router-dom';
const navbar = () => {
  return (
   <>
   <nav className='main-nav'>
    <div className='logo'>
        <h2>
            <Link to="/">
           <img src={logo} ></img>
           </Link>
        </h2>
    </div>
    <div className='menu-link'>
        <ul>
            <li>
                <NavLink to='/holidays'>Holidays</NavLink>
            </li>
            <li>
                <NavLink to='/hotels'>Hotels</NavLink>
            </li>
            <li>
                 <NavLink to='/flight'>Flights</NavLink>
            </li>
            <li>
                <NavLink to='/gift-cards'>Gift Cards</NavLink>
            </li>
            <li>
                <NavLink to='/offers'>Offers </NavLink>
            </li>
        </ul>
    </div>
   </nav>
 
   </>
  )
}

export default navbar