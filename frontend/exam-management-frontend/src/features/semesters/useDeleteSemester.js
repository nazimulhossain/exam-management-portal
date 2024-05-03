import { useMutation, useQueryClient } from "@tanstack/react-query"
import { deleteSemesterApi } from "../../services/apiSemesters";
import toast from "react-hot-toast";

export const useDeleteSemester = ()=>{

    const queryClient = useQueryClient();
    const {mutate:deleteSemester, isPending: isDeleting} = useMutation({
        mutationFn:deleteSemesterApi,
        onSuccess:()=>{
            queryClient.invalidateQueries({
                queryKey: ['semestersbycourse']
            })
            toast.success("Semester Deleted Successfully");
        }
    })

    return {deleteSemester,isDeleting}

}