const ItemFinans = (table) => {
    return (
        <>
            <li className="lastcghange__item flex-1 self-center">{table.date}</li>
            <li className="lastcghange__item flex-1 self-center">{table.category}</li>
            <li className="lastcghange__item flex-1 self-center">{table.summ}</li>
            <li className="lastcghange__item flex-1 self-center">{table.com}</li>
            <li className="lastcghange__item flex-1 self-center">{table.name}</li>

        </>
    )

}

export default ItemFinans;