# 2. Duplicated Products
# You are given a complex list of n products, each with a name, price,
# and weight. Find out how many duplicate products are present
# within the list. Duplicate products contain identical parameters for
# all fields in the list (i.e. name, price, and weight).
# Example:
# There are n = 5 products with attributes listed in three arrays,
# aligned by index.
# name = [ball, bat, glove, glove, glove]
# price = [2, 3, 1, 2, 1]
# weight = [2, 5, 1, 1, 1]
# A complete item description for item 0: (name[0], prices[0], 0:
# weight[0]) is (ball, 2, 2)
# Name
# Price Weight
# ball
# 2
# 2
# bat
# 3
# 5
# glove
# 1
# 1
# glove
# 2
# 1
# glove
# 1
# 1
# The first two items are unique.
# The two gloves at indices 2 and 4 are equal in all three attributes so
# there is 1 duplicate.
# The last glove at index 3 has a different price from the other two, so
# it is not a duplicate.
# There is 1 duplicate item in the original list.
#
# Function Description
# Complete the function numDuplicates in the editor below. The
# function must return an integer denoting the number of duplicates
# within the product list.
# numDuplicates has the following parameter(s):
# string name[n}. string array of size n, where names[i] denotes the
# name of the product at the index of i.
# int price[n): int array of size n, where prices[i] denotes the price of
# the product at the index of i.
# int weight[n]. int array of size n, where weights[i] denotes the
# weight of the product at the index of i.

def numDuplicates(name, price, weight):
    n = len(name)
    products = [(name[i], price[i], weight[i]) for i in range(n)]
    unique_products = set(products)
    return n - len(unique_products)


if __name__ == '__main__':
    result = numDuplicates(['ball', 'bat', 'glove', 'glove', 'glove'], [2, 3, 1, 2, 1], [2, 5, 1, 1, 1])
    print(result)
