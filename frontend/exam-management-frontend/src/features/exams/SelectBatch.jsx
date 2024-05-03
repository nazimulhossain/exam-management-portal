function SelectBatch({batch}){

    const onBatchHandler = ()=> {
        console.log("hit")
    }

    return (
        <>
            <li className="text-lg hover:bg-slate-100 hover:cursor-pointer p-2" onClick={()=>onBatchHandler(batch.batchName)}>{batch.batchName}</li>
           

        </>
    )

}


export default SelectBatch;