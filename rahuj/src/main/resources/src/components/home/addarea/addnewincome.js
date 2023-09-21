import ButtonHome from "../listarea/buttonHome";
import ListFinans from "../listarea/listfinans";
import GetComeCategory from "./getComeCategory";

const AddNewIncome = () => {
    const getCategory = fetch("http://localhost:8080/api/categories/expenditureCategory");
    getCategory.then((data) => { console.log(data) });
    return (
        <div className="flex flex-col bg-[#7b8a8a] p-5 m-5 rounded-2xl gap-5">
            <div className="text-center text-4xl text-light-green">Всі доходи</div>
            
            <div className="bg-[#52aea3] flex flex-col p-3 rounded-xl">
                <div className="flex place-content-around items-stretch gap-4 items-center">
                    <input className="lastcghange__item flex-1 self-center" type="date" id="date" name="date" />
                    <input id = "inputComeCategory" name="category" placeholder="категорія" className="lastcghange__item flex-1 self-center" onClick={() =>{document.querySelector("#comeCatHiden").className = "flex gap-2 flex-wrap"}}>

                    </input>
                    <input className="lastcghange__item flex-1 self-center" type="number" placeholder="сума"></input>
                    <textarea className="lastcghange__item flex-1 self-center" placeholder="коментар"></textarea>
                    <ButtonHome name="зберегти"></ButtonHome>
                </div>
                <div className="hidden" id="comeCatHiden">
                    <GetComeCategory></GetComeCategory>
                </div>
            </div>

            <ListFinans></ListFinans>

        </div>

    )
}

export default AddNewIncome;