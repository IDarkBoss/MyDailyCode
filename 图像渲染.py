class Solution:
    def floodFill(self, image, sr, sc, newColor):
        height = len(image) - 1
        width = len(image[0]) - 1
        color = image[sr][sc]

        if color == newColor:
            return image

        def find(sr, sc):
            if image[sr][sc] == color:
                image[sr][sc] = newColor

                if sr > 0:
                    find(sr - 1, sc)
                if sr < height:
                    find(sr + 1, sc)
                if sc > 0:
                    find(sr, sc - 1)
                if sc < width:
                    find(sr, sc + 1)

        find(sr, sc)
        return image


image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
sr = 1
sc = 1
newColor = 2
image = Solution.floodFill(None, image, sr, sc, newColor)

print(image)
