import GetAllListCost from "./getAllListCost";
import AddFilsToCostPage from "./addFilsToCostPage";

const AddNewCosts = () => {
    return (

        <div className="bg-[#7b8a8a] flex flex-col place-content-around p-3 m-5 rounded-xl items-stretch gap-4 items-center">
            <div className="text-center text-4xl text-light-green">Додати витрату:</div>
            
            <AddFilsToCostPage></AddFilsToCostPage>
{/*             <AddFilsAll link = {"http://localhost:8080/api/expenditure/"} category = {"expenditureCategoryDTO"}/>*/}
            <div className="text-center text-4xl text-light-green">Список витрат:</div> 
           
            <GetAllListCost></GetAllListCost>
            
        </div>


    )
}

export default AddNewCosts;