import { useContext, useState } from "react";
import {Login} from "../../App"

class Servises {
    
    _link = "http://localhost:8080/api/";

    
    async getCategoryCost () {
        
        const data = await fetch(`${this._link}categories/expenditureCategory`);
        //const data = await fetch(`${this._link}categories/expenditureCategory/?login=vadik`);
        
        return await data.json();
    };
    
    async getCategoryCome () {
        const data = await fetch(`${this._link}categories/revenueCategory`);
        return await data.json();
    }
    async getListCost () {
        const data = await fetch(`${this._link}expenditure`);
        //const data = await fetch(`${this._link}expenditure/?login=vadik`);
        return await data.json();
    }
    async getListCome () {
        const data = await fetch(`${this._link}revenue/`);
        return await data.json();
    }
}

export default Servises;