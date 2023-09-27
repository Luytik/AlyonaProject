import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Header from "./components/header/header";
import Footer from "./components/footer/footer";
import Mainpage from "./components/mainpage/mainpage";
import Home from './components/home/home';
import AddNewIncome from './components/home/addarea/addnewincome';
import HomeIndex from './components/home/listarea/homeindex';
import AddNewCosts from './components/home/addarea/addnewcosts';
import Statistics from './components/home/statistics/statistics';

function App() {
  return (
    <Router>
      <div className="App relative">
        <Header></Header>
        <Routes>
          <Route path='/' element={<Mainpage />} />
          <Route path='/home' element={<Home />}>
            <Route index element={<HomeIndex />} />

            <Route path="/home/new_income" element={<AddNewIncome />} />
            <Route path="/home/new_costs" element={<AddNewCosts/>} />
            <Route path="/home/new_statistics" element={<Statistics/>} />


          </Route>
        </Routes>
        <Footer></Footer>
      </div>
    </Router>
  );
}

export default App;
