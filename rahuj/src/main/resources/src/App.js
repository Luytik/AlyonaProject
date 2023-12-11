import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Header from "./components/header/header";
import Footer from "./components/footer/footer";
import Mainpage from "./components/mainpage/mainpage";
import Home from "./components/home/home";
import AddNewIncome from "./components/home/addarea/addnewincome";
import HomeIndex from "./components/test/homeindex";
import AddNewCosts from "./components/home/addarea/addnewcosts";
import Statistics from "./components/home/statistics/statistics";
import FinansPage from "./components/finans/finansPage";
import FAQ from "./components/faq/faqPage";
import AboutUs from "./components/aboutus/aboutUsPage";
import LoginPage from "./components/loginpage/logippage";

import React, { createContext, useEffect, useState } from "react";

/* const App = observer(() => {
  
  useEffect(() => {
     AuthStore.checkAuth();
  }, []);
 */
const Login = createContext(null);

function App() {
  const [isLogin, setIsLogin] = useState(localStorage.getItem("loginName"));
  function onLogin(data) {
    setIsLogin(data);
  }

  console.log(isLogin);
  if (isLogin !== null) {
    localStorage.setItem("loginName", isLogin);
  }
  console.log(localStorage.getItem("loginName"));
  //localStorage.setItem("test","значення ключа test");

  /*   useEffect(() => {
    AuthStore.checkAuth();
 }, []);
 */

  return (
    <Router activeClassName="text-green">
      <div className="h-screen grid auto-rows-fr gap-0">
        <Header></Header>
        <div className="row-[span_7_/_span_7] overflow-auto">
          <Login.Provider value={[isLogin, onLogin]}>
            <Routes>
              <Route path="/" element={<Mainpage />} />
              <Route path="/finans" element={<FinansPage />} />
              <Route path="/faq" element={<FAQ />} />
              <Route path="/aboutus" element={<AboutUs />} />

              {/* <Route path="/home" element={<PrivateRoute  />}>
                <Route path="" element={<AddNewIncome />} />
                <Route path=":id" element={<AddNewIncome />} />
            </Route>

            <Route path="*" element={<div>404... not found </div>} /> */}

              <Route path="/home" element={<Home />}>
                {/* <Route index element={<HomeIndex />} /> */}

                <Route path="/home/new_income" element={<AddNewIncome />} />
                <Route path="/home/new_costs" element={<AddNewCosts />} />
                <Route path="/home/new_statistics" element={<Statistics />} />
                <Route index element={<LoginPage />} />
              </Route>
            </Routes>
          </Login.Provider>
        </div>

        <Footer></Footer>
      </div>
    </Router>
  );
}

export { App, Login };
