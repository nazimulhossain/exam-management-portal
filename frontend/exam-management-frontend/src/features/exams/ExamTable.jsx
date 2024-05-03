import ExamRow from "./ExamRow";



function ExamTable({exam}){


    return(
    <div className="flex flex-col gap-4">
        <h2 className="text-3xl mb-3">Exam Details</h2>
        <div className="border-2 border-slate-200 bg-white" role="table">
        <header className="grid grid-cols-[0.5fr_1fr_0.5fr_0.5fr_0.5fr] gap-2 bg-slate-200 p-3 uppercase justify-items-center" role="header">
            <div>
                Name
            </div>
           <div>
             Description
           </div>
            <div>
             Total Marks
            </div>
            <div>
                Edit
            </div>
            <div>
                Delete
            </div>
            </header>
        
                <ExamRow exam={exam} />
                
                  
                </div>
      
            
        </div>

    )

}

export default ExamTable;