import { useState, useEffect } from "react";

import Servises from "../servises/servises";

const mass = [];
function GetSortListAll() {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState([]);

  useEffect(() => {
    new Servises().getListCost().then(
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

  console.log(items);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Загрузка...</div>;
  } else {
    mass = items;
    console.log(items);
    console.log(mass);
  }
}
const Testlist = () => {
  console.log(mass);
  return mass.map((item, index) => (
    <div className="bg-[#52aea3] flex place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
      <div className="lastcghange__item flex-1 self-center" key={index + "yq"}>
        {item.date}
      </div>
      <div className="lastcghange__item flex-1 self-center" key={index + "we"}>
        {item.money}
      </div>
      <div className="lastcghange__item flex-1 self-center" key={index + "qf"}>
        {item.description}
      </div>
    </div>
  ));
};

export default Testlist;
