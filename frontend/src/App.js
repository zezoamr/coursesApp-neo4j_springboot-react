import './App.css';
import Home from './components/home/Home';
import Header from './components/header/Header';
import Register from './components/register/Register';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Header/>
      <Routes>
        <Route path='/' element={<Layout/>}>
          <Route path='/' element={<Home/>}></Route>
          <Route path='/Register' element={<Register/>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
