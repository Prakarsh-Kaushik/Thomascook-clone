import React,{useState} from 'react'
import Carousel from '../Carousel/carousel'
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import "./home.css";
import FeaturedTourList from '../FeaturedTours/featuredTourList';
import IndiaFeaturedTours from '../FeaturedTours/IndiaFeaturedTours';
import HoneymoonFeaturedTours from '../FeaturedTours/HoneymoonFeaturedTours';

const Home = () => {
  const [isOpen,setIsOpen] = useState(true);

  return (
    <>
    
    <Carousel/>
    <div class="main-content">
      <h2 class="main-heading">International Holiday Packages</h2>
    
    </div>
 <section>
  <FeaturedTourList/>
 </section>

 <div class="main-content">
      <h2 class="main-heading">India & Around Holiday Packages</h2>
      </div>
      

 <section>
  <IndiaFeaturedTours/>
 </section>
 <div class="main-content">
      <h2 class="main-heading">Honeymoon Holiday Packages</h2>
</div>
<section>
  <HoneymoonFeaturedTours/>
</section>

<div class="main-content">
      <h2 class="main-heading">Why Thomas Cook?</h2> 
</div>
<section>


<div class="card-group">
<div class="card text-center">
        <img src="https://img.freepik.com/premium-vector/green-shield-icon-with-checkmark-confirmation-protection-security-shield-protected-icon-vector_662353-818.jpg?w=2000" class="card-img-top cardImg" alt="..."/>
        <div class="card-body">
            <h5 class="card-title">Your Trusted Advisor</h5>
            <p class="card-text"> We’ll answer your every question. Our experienced travel experts and real-time on field know-how gives us this advantage. </p>
        </div>
       
       
    </div>
    <div class="card text-center">
        <img src="https://www.creativefabrica.com/wp-content/uploads/2021/06/16/Call-center-customer-support-icon-Graphics-13498424-5-580x376.jpg" class="card-img-top cardImg" alt="..."/>
        <div class="card-body">
            <h5 class="card-title">We Love Listening</h5>
            <p class="card-text"> Your holiday, your terms. We’ll fill in the blanks to plan the perfect trip in the blink of an eye.</p>
        </div>
       
    </div>
    <div class="card text-center">
        <img src="https://img.freepik.com/premium-vector/star-logo-design-template-vector_487414-163.jpg" class="card-img-top cardImg" alt="..."/>
        <div class="card-body">
            <h5 class="card-title">Best Experiences</h5>
            <p class="card-text"> Do everything or do nothing. Either way, your holiday will be nothing less than extraordinary.  </p>
        </div>
      
    </div>
    <div class="card text-center">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyeO855lm_1lvdWnovZRURRVY2zpiI1XjTOpm0fN5hv6IscKDdgzdUvWLYkLDbVamdTnA&usqp=CAU" class="card-img-top cardImg" alt="..."/>
        <div class="card-body">
            <h5 class="card-title">Easy as ABC</h5>
            <p class="card-text">Travel smooth and stress-free. That’s how easy we make it because that’s how your holiday should be.</p>
        </div>
      
    </div>
    <div class="card text-center">
        <img src="https://png.pngtree.com/png-vector/20190507/ourlarge/pngtree-vector-airplane-icon-png-image_1025191.jpg" class="card-img-top cardImg" alt="..."/>
        <div class="card-body">
            <h5 class="card-title">Handcrafted Holidays</h5>
            <p class="card-text"> We interact with our loyal customers to co-create unique experiences that will take your holiday to the next level.  </p>
        </div>
        
    </div>
</div>





</section>

<div class="main-content">
      <h2 class="main-heading">Tours and Travel Agency – Thomas Cook India</h2> 
</div>
<section>
<p className='cardBottom'>“Travel is the only thing you buy that makes you richer”. We completely swear by this and believe in fulfilling travel dreams that make you invariably rich by the day. We have been selling beautiful experiences for years through our state-of-the-art designed holiday packages and other essential travel services. We inspire our customers to live a rich life, full of unforgettable travel experiences."

Our mission is not just to be a travel agency which helps you book a holiday; we want to be your travel partner who would go an extra mile to help you choose an ideal destination and learn more about the place you have been dreaming to visit. Since holidays are more about personal choices and interests, we bring to you customizable tour packages as well. We give you the prerogative to pick and choose anything that matches your interest. No matter how many travel experiences we sell every day, we ensure that you are the protagonist of your own travel story.

</p>
</section>
  </>
  )
}

export default Home