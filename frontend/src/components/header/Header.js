import React from 'react'
import Button from 'react-bootstrap/Button'
import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons'
import { useNavigate, NavLink, Link } from 'react-router-dom'


const Header = () => {

    const navigate = useNavigate();

    const handleNav = (path) => {
        navigate(path);
    }

  return (
    <Navbar>
        <Container fluid>
            <Navbar.Brand href='/' className='menu-link' style={{'color' : 'white'}}>
                <FontAwesomeIcon icon={faGraduationCap}></FontAwesomeIcon>
            </Navbar.Brand>
            <Navbar.Toggle/>
            <Nav
                className='ms-auto my-2 my-lg-0'
                style={{"maxHeight": "100px"}}
                navbarScroll
            >
                
            </Nav>
            <>
            <Button variant='info' className='me-2'> Login </Button>
            <Button variant='info' className='me-2' onClick={() => handleNav("/Register")} >Register</Button>
            </>
        </Container>
    </Navbar>
  )
}

export default Header