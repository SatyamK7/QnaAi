import { useState } from "react"


export default function Input ({ onSubmit }) {
    const [question,setQuestion] = useState("")
    const handleSubmit = (e) => {
        e.preventDefault();
        if(question.trim()) {
            onSubmit(question)
            setQuestion("")
        }

        
    }
    return (
        <>
            <div className="container my-4">
                <div className="flex flex-col md:flex-row items-center justify-between gap-4 p-6 bg-white rounded-xl shadow-md max-w-2xl mx-auto mt-10 w-9/12">
            <div className="w-full md:w-3/4">
                <label htmlFor="question" className="block text-sm font-medium text-gray-700 mb-1">
                Ask a Question
                </label>
                <input
                type="text"
                id="question"
                placeholder="Enter the question"
                onChange={(e) => setQuestion(e.target.value)}
                className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 transition"
                />
            </div>

            <button
                type="submit"
                onClick={handleSubmit}
                className="bg-gray-900 hover:bg-gray-800 text-white font-semibold px-6 py-2 rounded-lg transition cursor-pointer"
            >
                Submit
            </button>
            </div>

            </div>
        </>
    )
}