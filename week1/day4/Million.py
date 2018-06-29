import unittest


class Trie(object):

    # Implement a trie and use it to efficiently store strings
    def __init__(self,):
        self.node = {}

    def add_word(self, word):
        node = self.node
        for c in word:
            if node.has_key(c):
                node = node[c]
            else:
                node[c] = {}
                node = node[c]
        
        if node.has_key('*'):
            return False
        node['*'] = {}
        return True

# Tests

class Test(unittest.TestCase):

    def test_trie_usage(self):
        trie = Trie()

        result = trie.add_word('catch')
        self.assertTrue(result, msg='new word 1')

        result = trie.add_word('cakes')
        self.assertTrue(result, msg='new word 2')

        result = trie.add_word('cake')
        self.assertTrue(result, msg='prefix of existing word')

        result = trie.add_word('cake')
        self.assertFalse(result, msg='word already present')

        result = trie.add_word('caked')
        self.assertTrue(result, msg='new word 3')

        result = trie.add_word('catch')
        self.assertFalse(result, msg='all words still present')

        result = trie.add_word('')
        self.assertTrue(result, msg='empty word')

        result = trie.add_word('')
        self.assertFalse(result, msg='empty word present')


unittest.main(verbosity=2)