import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Header from "./components/header/header";
import Footer from "./components/footer/footer";
import Mainpage from "./components/mainpage/mainpage";
import Home from './components/home/home';
import ListFinans from './components/home/listarea/listfinans';
import AddNew from './components/home/addarea/addnew';
import HomeIndex from './components/home/listarea/homeindex';

function App() {
  return (
    <Router>
      <div className="App relative">
        <Header></Header>
        <Routes>
          <Route path='/' element={<Mainpage />} />
          <Route path='/home' element={<Home />}>
            <Route index element={<HomeIndex />} />

            <Route path="/home/new" element={<AddNew />} />

          </Route>
        </Routes>
        <Footer></Footer>
      </div>
    </Router>
  );
}

export default App;
