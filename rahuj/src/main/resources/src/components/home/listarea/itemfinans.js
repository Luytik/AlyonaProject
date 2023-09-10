const ItemFinans = (table) => {
    const liMass = [table.date, table.category, table.summ, table.com, table.name];
    const liItem = liMass.map((item) => <li className="lastcghange__item flex-1 self-center" key={item.id*2+25}>{item}</li>);
    
    return (
        <ul className="bg-[#52aea3] flex place-content-around p-3 rounded-xl items-stretch gap-4 items-center">
            {liItem}
        </ul>
    )

}

export default ItemFinans;