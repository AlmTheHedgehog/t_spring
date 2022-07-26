import logo from './logo.svg';
import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import BooksListComponent from './Components/BooksListComponent';
import HeaderComponent from './Components/HeaderComponent';
import FooterComponent from './Components/FooterComponent';
import NotFoundComponent from './Components/NotFoundComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className = "container">
          <Routes>
            <Route path = "/allbooks" element = {<BooksListComponent/>}/>
            <Route path="*" element={<NotFoundComponent/>}/>
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
