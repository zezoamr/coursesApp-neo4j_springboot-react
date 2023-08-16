import React from 'react'
import Button from 'react-bootstrap/Button'
import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import Navbar from 'react-bootstrap/Navbar'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faGraduationCap } from '@fortawesome/free-solid-svg-icons'


const Header = () => {
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
                <Button variant='info' className='me-2'> Login </Button>
                <Button variant='info' className='me-2'> Register </Button>
            </Nav>
        </Container>
    </Navbar>
  )
}

export default Header