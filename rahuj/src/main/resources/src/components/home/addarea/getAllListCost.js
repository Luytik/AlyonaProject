import { useState, useEffect, useContext } from "react";

import Servises from "../../servises/servises";
import {Login} from "../../../App"

function GetAllListCost() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([]);

const login = useContext(Login)

  useEffect(() => {

    fetch(`http://localhost:8080/api/expenditure/?login=${login[0]}`)
    //new Servises().getListCost()
    .then(res => res.json())  
    
    .then(
        (result) => {
          setIsLoaded(true);
          setItems(result);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }

      )
console.log(items);
  }, [])



  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Загрузка...</div>;
  } else {
    return (
      <>
        {items.map((item, index) => (
          <div className="bg-[#52aea3] flex place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
            <div className="lastcghange__item flex-1 self-center" key={index + "yq"}>{item.date}</div>
            <div className="lastcghange__item flex-1 self-center" key={index + "rw"}>{item.expenditureCategoryDTO.expenditureCategoryDTO}</div>
            <div className="lastcghange__item flex-1 self-center" key={index + "we"}>{item.money}</div>
            <div className="lastcghange__item flex-1 self-center" key={index + "qf"}>{item.description}</div>
          </div>
        ))
        }
      </>
    );
  }
}

export default GetAllListCost;