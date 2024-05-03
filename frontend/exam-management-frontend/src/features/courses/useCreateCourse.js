import { useMutation, useQueryClient } from "@tanstack/react-query";
import { createCourse } from "../../services/apiCourses";
import toast from "react-hot-toast";

export function useCreateCourse(){
    const queryClient = useQueryClient();

    const{mutate:createCourses, isPending: isCreating } = useMutation({
        mutationFn: createCourse,
        onSuccess: ()=>{
            queryClient.invalidateQueries({
                queryKey: ['courses']
            })
            toast.success("Course created successfully");
        }
    })

    return {createCourses,isCreating}
}