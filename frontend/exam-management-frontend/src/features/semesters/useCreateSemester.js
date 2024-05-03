import { useMutation, useQueryClient } from "@tanstack/react-query";
import toast from "react-hot-toast";
import { createSemesterApi } from "../../services/apiSemesters";

export function useCreateSemester(){
    const queryClient = useQueryClient();

    const{mutate:createSemester, isPending: isCreating } = useMutation({
        mutationFn:createSemesterApi ,
        onSuccess: ()=>{
            queryClient.invalidateQueries({
                queryKey: ['semesters']
            })
            toast.success("Semester created successfully");
        }
    })

    return {createSemester,isCreating}
}