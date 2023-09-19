import ButtonHome from "../listarea/buttonHome";
import ListFinans from "../listarea/listfinans";
import GetSelectCategory from "./getSelectCategory";

const AddNewCosts = () => {
    return (
        <div className="flex flex-col bg-[#7b8a8a] p-5 m-5 rounded-2xl gap-5">
            <div className="text-center text-4xl text-light-green">Додати витрати</div>

            <div className="bg-[#52aea3] flex flex-col place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
                <div className="flex gap-3">
                    <div className="flex flex-col gap-3 w-1/3">
                        <input className="lastcghange__item self-center w-full" type="date" id="date" name="date" />
                        <input className=" w-full" id = "valueCategoryCosts" type="text" placeholder="категорія"></input>
                        <input className="lastcghange__item self-center  w-full" placeholder="сума" type="number"></input>
                        <textarea className="lastcghange__item self-center  w-full"></textarea>
                    </div>
                    <div>
                        <ul className="flex gap-2 flex-wrap">
                            <GetSelectCategory></GetSelectCategory>
                        </ul>
                    </div>
                </div>
                <ButtonHome name="зберегти" onClick={() => document.getElementById('my_modal_1').showModal()}></ButtonHome>
            </div>



        </div>

    )
}

export default AddNewCosts;