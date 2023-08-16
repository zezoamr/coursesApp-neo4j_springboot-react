import React from 'react'
import HeroImage from '../../images/School.jpg';
import './Home.css'

const Home = () => {
  return (
    <div className='container'>
        <img src={HeroImage} alt = "HeroImage" />
    </div>
  )
}

export default Home