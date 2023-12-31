import { useState, useEffect } from "react";
import Servises from "../../servises/servises";

function GetCostCategory() {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);

    useEffect(() => {
        new Servises().getCategoryCost()
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





    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Загрузка...</div>;
    } else {
        return (
            <>
                {items.map((item, index) => (
                    <div className="border-2 p-3 hover:border-4 cursor-pointer" value={item.expenditureCategoryDTO} key={index + "b"} onClick={()=> {document.querySelector("#inputComeCategory").value = item.expenditureCategoryDTO}} >{item.expenditureCategoryDTO}</div>
                ))
                }


            </>
        );
    }
}

export default GetCostCategory;