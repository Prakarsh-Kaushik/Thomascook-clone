import React from "react";
import './holidays.css';
import { useNavigate} from "react-router-dom";


function Holidays() {
  const cities =  
  [
  { id: 1, country:"France", location: "Paris", image: "./img/paris.jpeg",price:92999,  },
  { id: 2, country: "England", location: "London", image: "./img/london.jpeg",price:82999, overview: "The English writer Samuel Johnson famously said, 'You find no man, at all intellectual, who is willing to leave London. No, Sir, when a man is tired of London, he is tired of life; for there is in London all that life can afford.' More than two centuries have passed since Johnson's era, but his words still ring true. Life in London is nothing short of invigorating, and travelers find that one visit isn't enough to experience everything this two-millennia-old city has to offer." },
  { id: 3, country: "Japan", location: "Tokyo", image: "./img/tokyo.jpeg",price:95999, overview: "'Animated' is perhaps the best word to describe Tokyo. Crazy about its anime, Japan's mega city is constantly buzzing with movement – feet clacking down sidewalks, cars zooming along streets, subway trains humming below ground, ships cruising in and out. And yet bright lights and loud signs beg you to pause, to break your motion for just one second to pray (oops, we mean pay) at the altar of consumerism. This is a city that feeds on motion and progress." },
  { id: 4, country: "Italy", location: "Rome", image: "./img/rome.jpeg",price:79999, overview: "Rome, the city of seven hills, enjoyed a mythic beginning. Romulus and Remus – twin brothers who were nursed by a she-wolf and fathered by a war god – reportedly founded the Eternal City. And although historians are a little skeptical about this epic entry into the world, most travelers are absolutely certain that there is something magical about Rome. Whether it's the mystery of nearby Vatican City or the ghosts of the Colosseum, an afternoon caffè on Piazza Navona or a piled-high plate of pasta at a trattoria, Roma is sure to enchant." },
  { id: 5, country: "Spain", location: "Barcelona", image: "./img/barcelona.jpeg",price:65999, overview: "Barcelona contains both the authentically historic and the wildly bizarre. From the scenic trails of the colorful Park Güell to the romantic narrow alleys of Barri Gòtic; from the beachside nightclubs to the city's dozens of sacred churches and architectural marvels, this city by the sea seems to attract all types: the adventurer, the couple, the partier, the culture lover – and more – with an almost overwhelming variety of things to do. You could stay for a few days, but chances are you'll need a whole week to explore." },
  { id: 6, country: "USA", location: "New York",image: "./img/newyork.jpeg",price:74999, overview: "Cool, cosmopolitan, crowded, constantly evolving … the Big Apple blends big city splendor with small-town charm. Amid Gotham's iconic landmarks and towering skyscrapers, you'll experience a vibrant culture permeating each of the city's distinctive neighborhoods and boroughs. Follow trendsetters to the East Village and Brooklyn to check out indie boutiques, iconic bakeries and trendy coffee shops. Afterward, peruse the racks of the sleek shops lining Fifth Avenue, admire the cutting-edge art collections at the MoMA and the Met, catch a memorable show on Broadway or sit down for a meal at the latest 'it' restaurant." },
  { id: 7, country: "Greece", location: "Santorini", image: "./img/santorini.jpeg",price:91999, overview: "A massive volcanic eruption around 1650 B.C. forced the center of what was then a single island to implode and succumb to the sea. Some say that this was the original home of the lost city of Atlantis, which long ago disappeared into the ocean's depths. Whatever remains of this mythological metropolis is now guarded by beautiful beaches and stately whitewashed homes. Today, Santorini consists of two inhabited islands and several islets. Most visitors spend their time on Thira (the archipelago's largest island), which is home to Santorini's major towns, including Fira and Oia. Sleepy Thirassia makes for a relaxing daytrip too. And don't count out the quieter islands: Nea Kameni and Palea Kameni are worth exploring." },
  { id: 8, country: "Netherlands", location: "Amsterdam", image: "./img/amsterdam.jpeg",price:83999, overview: "Don't believe everything you hear about Amsterdam. Yes, this Netherlands city takes a lax look at women beckoning business in the Red Light District and 'coffee shops' selling an unorthodox type of herb to a toking clientele, but these descriptions only scratch the surface. At some point, during an excellent Indonesian meal, a twilight canal-side rambling or a shopping excursion through the boutiques of Nine Little Streets, you'll realize – as many travelers have before you – that there's much more to Amsterdam than you might've thought." }
]

const navigate =useNavigate();




  
  const citii = cities.map((city) =>
  {
    const holidayPrice = city.price;
    
 
    return(
  
  <>

  <div class="row" key={city.id}>
    <div class="col" ><img src={city.image} alt={city.location} style={{width:"250px"}}/></div>
    <div class="col" style={{marginTop:"4%",fontSize:"30px",marginLeft:"4%"}}>{city.country}</div>
   
    <div class="col" style={{marginTop:"4%",fontSize:"30px",marginLeft:"4%"}}>{city.location}</div>
    <div class="col" style={{marginTop:"4%",fontSize:"30px",marginLeft:"40px"}}>Rs. {holidayPrice}</div>

    <div class="col" style={{marginTop:"3%"}}><button class="btn-5" onClick={()=>navigate("/dform",{state:holidayPrice})}>Book Now</button></div>
  </div>

</>
  )})

  return (
  <div>
    {citii}
  </div>
  )
}

export default Holidays;