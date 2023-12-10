import { useState, useEffect, useContext } from "react";
import Servises from "../../servises/servises";
import { Login } from "../../../App";

function GetComeCategory() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([]);

  const login = useContext(Login);

  useEffect(() => {
    fetch(
      `http://localhost:8080/api/categories/revenueCategory/?login=${login[0]}`
    )
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setItems(result);
        },

        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Загрузка...</div>;
  } else {
    return (
      <>
        {items.map((item, index) => (
          <div
            className="border-2 p-3 hover:border-4 cursor-pointer"
            value={item.revenueCategoryDTO}
            key={index + "b"}
            onClick={() => {
              document.querySelector("#inputComeCategory").value =
                item.revenueCategoryDTO;
            }}
          >
            {item.revenueCategoryDTO}
          </div>
        ))}
      </>
    );
  }
}

export default GetComeCategory;
