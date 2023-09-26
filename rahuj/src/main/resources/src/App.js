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
      <div className="h-screen grid auto-rows-fr gap-0">
        <Header></Header>
        <div className='row-[span_7_/_span_7] overflow-auto'>
          <Routes>
            <Route path='/' element={<Mainpage />} />
            <Route path='/home' element={<Home />}>
              <Route index element={<HomeIndex />} />

              <Route path="/home/new_income" element={<AddNewIncome />} />
              <Route path="/home/new_costs" element={<AddNewCosts />} />
              <Route path="/home/new_statistics" element={<Statistics />} />


            </Route>
          </Routes>
        </div>

        <Footer></Footer>
      </div>
    </Router>
  );
}

export default App;
