import { useMutation, useQueryClient } from "@tanstack/react-query"

import toast from "react-hot-toast";
import { updateSemester } from "../../services/apiSemesters";

export const useEditSemester = ()=> {
    const queryClient = useQueryClient();
    const {mutate:editSemester, isPending: isEditing}= useMutation({
        mutationFn: updateSemester,
        onSuccess: ()=>{
            queryClient.invalidateQueries({
                queryKey: ['semesters']
            })

            toast.success("Semester updated successfully");
        },
        onError:()=> {
            toast.error("Semester not updated");
        }
    })

    return {editSemester,isEditing}

}