import { useMutation, useQueryClient } from "@tanstack/react-query";
import toast from "react-hot-toast";
import { createSemesterByCourseApi } from "../../services/apiSemesters";

export function useCreateSemesterByCourse(){
    const queryClient = useQueryClient();
   const {mutate:createSemesterbyCourse,isPending:isCreating} =useMutation({
        mutationFn: createSemesterByCourseApi,
        onSuccess:()=>{
            queryClient.invalidateQueries({
                queryKey:['semestersbycourse']
            })
            toast.success('Semester created succcessfully');
        },
        onError:()=>{
            toast.error("Semester not created");
        }

    })

    return {createSemesterbyCourse,isCreating};
}