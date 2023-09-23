import { useState, useEffect } from "react";
import MyComponent from "./testpost";
import MyFormAll from "./myFormAll";
import Servises from "../../servises/servises";

function Statistics() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([]);

  // Note: the empty deps array [] means
  // this useEffect will run once
  // similar to componentDidMount()
  /* useEffect(() => {
    new Servises().getCategoryCost()
      .then(
        (result) => {
          setIsLoaded(true);
          setItems(result);
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      )
  }, []) */
  useEffect(() => {
    new Servises().getListCost()
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
      
  }, [])

  
  console.log(items)

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Загрузка...</div>;
  } else {
    return (
      <>
        <MyFormAll/>
        <MyComponent />
       
        {items.map((item) => (
          <>
          <div>{item.date}</div>
          <div>{item.expenditureCategoryDTO.expenditureCategoryDTO}</div>
          <div>{item.money}</div>
          <div>{item.description}</div>
          </>
        ))
        }

      </>
    );
  }
}

export default Statistics;