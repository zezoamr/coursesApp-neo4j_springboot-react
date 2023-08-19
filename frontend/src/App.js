import './App.css';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Register from './components/register/Register';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Login from './components/login/Login';

function App() {
  return (
    <div className="App">
      <Header/>
      <Routes>
        <Route path='/' element={<Layout/>}>
          <Route path='/' element={<Home/>}></Route>
          <Route path='/Register' element={<Register/>}></Route>
          <Route path='/Login' element={<Login/>}></Route>
          <Route path='/Layout' element={<Layout/>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
