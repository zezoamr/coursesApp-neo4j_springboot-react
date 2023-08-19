import React, { useState, useEffect } from 'react'
import HeroImage from '../../images/School.jpg';
import './Home.css'
import { Link } from "react-router-dom";
import useAuth from '../../hooks/useAuth';
import useAxiosPrivate from '../../hooks/useAxiosPrivate';
import Spinner from '../spinner/Spinner';

const Home = () => {
  const { auth, setAuth } = useAuth();
  const [isLoading, setIsLoading] = useState(false);

  const [courseData, setCourseData] = useState();

  const axiosPrivate = useAxiosPrivate();

  const fetchCourses = async () => {
    setIsLoading(true);
    const response = await axiosPrivate.get("/api/v1/courses/");

    const cData = response.data;

    setCourseData(cData);
    setIsLoading(false);
  }
  useEffect(() => {
    if (auth?.user) {
      fetchCourses();
    }
  }, [])

  return (
    <>
      <Spinner loadSpinner={isLoading} />
      <div className='container'>
        {
          !auth?.user ? <img src={HeroImage}
            alt="HeroImage" /> : (courseData) ? courseData.map((d) => {
              return (
                <div key={
                  d.identifier
                }
                  className="card mt-2">
                    
                  <div className="card-header-layout">
                    <p className="card-header text-secondary bg-white">
                      <span className='course-title'>
                        <Link to={`/Course/${d.identifier}`}>{d.title} </Link>
                      </span>
                    </p>
                  </div>
                  
                  <div>
                    <hr /> {
                      d.lessons.map((l) => {
                        return (
                          <div key={
                            l.identifier
                          }
                            className="mt-2 text-center">
                            <h5 className="card-title mt-2">
                              <span className="text-dark">
                                {
                                  l.title
                                }</span>
                            </h5>
                          </div>
                        )
                      })
                    } </div>
                  <hr />

                </div>

              )

            }) : null
        } </div>
    </>
  )
}

export default Home
